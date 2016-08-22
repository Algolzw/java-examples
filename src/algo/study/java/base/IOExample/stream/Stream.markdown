<img src="../io类图.jpg" width="900" />

# 字节流
```
流: 流是一个连续字节的序列，输入流读取这个序列，输出流构建（写入）这个序列。InputStream和OutputStream所操纵的基本单元就是字节。
```

## 1、字节输入流

* #### InputStream
 	所有输入流的父类，标志从不同起源地输入的类，如：
 	1. 字节数组
 	2. String对象
 	3. 文件
 	4. 管道
 	5. 一系列其他流
 	6. 其他起源地，如internet链接等
 	
 * #### ByteArrayInputStream
 	即字符数组输入流。ByteArrayInputStream允许内存中一个（字节数组）缓冲区作为InputStream，从输入流读取的数据保存在该缓冲区中。
 
 * #### StringBufferInputStream
 	该类已废弃（Deprecated）,官方建议使用StringReader类
 	
 * #### FileInputStream 
 	用于从本地文件中读取信息，通常读取的是（通过构造函数）一个代表文件名的String，或者一个File或FileDescriptor对象
 
 * #### FilterInputStream子类和ObjectInputStream
 	是Java IO库里的“过滤器”（或装饰器Decorator）基础类，连接InputStream类提供更多有用的操作。
 
 * #### ObjectInputStream和DataInputStream
 	ObjectInputStream允许读取用户用户自定义的类（该类必须实现Serializable接口）；DataInputStream用语读取Java的基本数据类型。
 	
 * #### PipedInputStream
 	PipedInputStream是从与其它线程共用的管道中读取数据
 	
 * #### SequenceInputStream
 	将两个或多个输入流当作一个输入流依次读取
 
 * #### LineNumberInputStream
 	从流中读取数据时，会的到相应的行号
 
 * #### PushbackInputStream
 	查看最后一个字节，不满意就放入缓存区
 	
 * #### BufferedInputStream
 	缓冲、标记输入流，使用mark(limit)方法允许读入limit个字节，流使用完后，通过reset方法重置。
 	
 
## 字节输出流

> 字节输出流河输入流对应，但没有LineNumberInputStream、PushbackInputStream、SequenceInputStream和StringBufferInputStream，而多了个PrintStream.

* #### PrintStream
	打印输出流，主要向其他输出流或FileInputStream输入数据，自带缓冲。不会抛出IOException<br>
	

 
 

 
 
 