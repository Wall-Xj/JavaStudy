package com.xiejun.io.others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.xiejun.io.util.FileUtil;

public class SplitFile {
	// 文件路径
	private String filePath;
	// 文件名称
	private String fileName;
	// 文件长度
	private long length;
	// 块数
	private int size;
	// 每块大小
	private long blockSize;
	// 每块的名称
	private List<String> blockPath;
	// 分割后的存放目录
	private String destBlockPath;

	public SplitFile() {
		blockPath = new ArrayList<String>();
	}

	public SplitFile(String filePath, String destBlockPath) {
		this(filePath, 1024, destBlockPath);
	}

	public SplitFile(String filePath, long blockSize, String destBlockPath) {
		this();
		this.filePath = filePath;
		this.destBlockPath = destBlockPath;
		this.blockSize = blockSize;
		init();
	}

	/**
	 * 初始化操作 计算块数、确定文件名
	 */
	public void init() {
		File src = null;
		// 健壮性
		if (null == filePath || !(((src = new File(filePath)).exists()))) {
			return;
		}
		if (src.isDirectory()) {
			return;
		}

		this.fileName = src.getName();
		// 计算块数 实际大小与每块大小
		this.length = src.length();
		// 修正每块大小
		if (this.blockSize > length) {
			this.blockSize = length;
		}
		// 确定块数
		size = (int) (Math.ceil(length * 1.0 / this.blockSize));
		initPathName();
	}

	private void initPathName() {
		for (int i = 0; i < size; i++) {
			this.blockPath.add(destBlockPath + "/" + this.fileName + ".part"
					+ i);
		}
	}

	/**
	 * 文件的分割 0、第几块 1、起始位置 2、实际大小
	 * 
	 * @param destPath
	 *            分割文件的存放目录
	 */
	public void split(String destPath) {
		long beginPos = 0;// 起点
		long actualBlockSize = blockSize;// 实际大小
		// 计算所有块的大小、位置、索引
		for (int i = 0; i < size; i++) {
			if (i == size - 1) {// 最后一块
				actualBlockSize = length - beginPos;
			}
			splitDetail(i, beginPos, actualBlockSize);
			beginPos += actualBlockSize;// 本次的终点，下一次的起点
		}
	}

	/**
	 * 文件的分割 输入 输出
	 * 
	 * @param index
	 *            第几块
	 * @param beginPos
	 *            起始点
	 * @param actualBlockSize
	 *            实际大小
	 */
	private void splitDetail(int index, long beginPos, long actualBlockSize) {
		// 创建源
		File src = new File(this.filePath);// 源文件
		File dest = new File(this.blockPath.get(index));// 目标文件
		// 选择流
		RandomAccessFile raf = null;// 输入流
		BufferedOutputStream bos = null;// 输出流
		try {
			raf = new RandomAccessFile(src, "r");
			bos = new BufferedOutputStream(new FileOutputStream(dest));
			// 读取文件
			raf.seek(beginPos);
			// 缓冲区
			byte[] flush = new byte[1024];
			// 接收长度
			int len = 0;
			while (-1 != (len = raf.read(flush))) {
				if (actualBlockSize - len >= 0) {// 查看是否足够
					// 写出
					bos.write(flush, 0, len);
					actualBlockSize -= len;// 剩余量
				} else {// 写出最后一次的剩余量
					bos.write(flush, 0, (int) actualBlockSize);
					break;
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			FileUtil.close(bos, raf);
		}
	}

	/**
	 * 文件的合并
	 * 
	 * @param destPath
	 */
	public void merge1(String destPath) {
		// 创建源
		File dest = new File(destPath);
		// 选择流
		BufferedOutputStream bos = null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(dest, true));
			BufferedInputStream bis = null;
			for (int i = 0; i < this.blockPath.size(); i++) {

				bis = new BufferedInputStream(new FileInputStream(new File(
						this.blockPath.get(i))));
				// 缓冲区
				byte[] flush = new byte[1024];
				// 接收长度
				int len = 0;
				while (-1 != (len = bis.read(flush))) {
					bos.write(flush, 0, len);
				}
				bos.flush();
				FileUtil.close(bis);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			FileUtil.close(bos);
		}
	}

	public void merge(String destPath) {
		// 创建源
		File dest = new File(destPath);
		// 选择流
		BufferedOutputStream bos = null;// 输出流
		SequenceInputStream sis = null;// 输入流
		// 创建一个容器
		Vector<InputStream> vi = new Vector<InputStream>();

		try {
			for (int i = 0; i < this.blockPath.size(); i++) {
				vi.add(new BufferedInputStream(new FileInputStream(new File(
						this.blockPath.get(i)))));
			}
			bos = new BufferedOutputStream(new FileOutputStream(dest, true));
			sis = new SequenceInputStream(vi.elements());
			// 缓冲区
			byte[] flush = new byte[1024];
			// 接收长度
			int len = 0;
			while (-1 != (len = sis.read(flush))) {
				bos.write(flush, 0, len);
			}
			bos.flush();
			FileUtil.close(sis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			FileUtil.close(bos);
		}
	}

	public static void main(String[] args) {
		SplitFile split = new SplitFile("e:/aaa/2.txt", 50, "e:/aaa/bbb");
		System.out.println(split.size);
		// split.split("e:/aaa/bbb");
//		split.merge1("e:/aaa/bbb/test.txt");
		split.merge("e:/aaa/bbb/test1.txt");
	}

}
