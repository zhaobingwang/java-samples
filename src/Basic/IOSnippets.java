package Basic;

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

public class IOSnippets {
    public static void main(String[] args) throws IOException {
//        tmp();
//        createFile();
//        createTmpFile();
//        listFiles();

//        File currentDir = new File("c:\\tmp");
//        String tree = "";
//        listAllFiles(currentDir, tree);

//        writeToFile();
        SerializationSnippets();
    }

    private static void tmp() throws IOException {
        // Windows平台使用\作为路径分隔符，在Java字符串中需要用\\表示一个\。
        // Linux平台使用/作为路径分隔符：
        File f = new File("C:\\Windows\\notepad.exe");
        System.out.println(f.getPath());

        File f2 = new File(".");
        System.out.println(f2.getCanonicalPath());

        File f3 = new File("C:\\Windows");
        File f4 = new File("C:\\Windows\\notepad.exe");
        File f5 = new File("C:\\Windows\\nothing");
        System.out.println(f3.isFile());
        System.out.println(f3.isDirectory());
        System.out.println(f4.isFile());
        System.out.println(f4.isDirectory());
        System.out.println(f5.isFile());
        System.out.println(f5.isDirectory());
    }

    private static void createFile() throws IOException {
        File file = new File("./out/tmp.txt");
        if (file.createNewFile()) {
            System.out.println("File created successfully: " + file.getCanonicalPath());
            if (file.delete())
                System.out.println("File deleted successfully: " + file.getAbsolutePath());
        }
    }

    private static void createTmpFile() throws IOException {
        File file = File.createTempFile("java-tmp-", ".txt");  // 创建临时文件，指定临时文件前缀和后缀
        file.deleteOnExit();    // JVM退出时自动删除
        System.out.println(file.isFile());
        System.out.println(file.getCanonicalPath());
    }

    private static void listFiles() {
        File f = new File("C:\\Windows");
        File[] fs1 = f.listFiles();
        printFiles(fs1);
        File[] fs2 = f.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".exe"); // 返回true表示接受该文件
            }
        });
        printFiles(fs2);
    }

    private static void printFiles(File[] files) {
        System.out.println("=========");
        if (files == null)
            return;
        for (var file : files) {
            System.out.println(file);
        }
        System.out.println("=========");
    }

    private static void listAllFiles(File dir, String t) {
        File[] fs = dir.listFiles();
        if (fs == null)
            return;
        for (var f : fs) {
            System.out.println(t + f.getName());
            listAllFiles(f, " -");
        }

    }

    private static void writeToFile() {
        try (OutputStream output = new FileOutputStream("./out/tmp.txt")) {
            output.write("Hello".getBytes("utf-8"));
        } catch (Exception e) {
        }
        // 编译器在此自动为我们写入finally并调用close()
    }

    // 因为Java的序列化机制可以导致一个实例能直接从byte[]数组创建，而不经过构造方法，
    // 因此，它存在一定的安全隐患。一个精心构造的byte[]数组被反序列化后可以执行特定的Java代码，从而导致严重的安全漏洞。
    private static void SerializationSnippets() throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try (ObjectOutputStream output = new ObjectOutputStream(buffer)) {
            // 写入int:
            output.writeInt(12345);
            // 写入String:
            output.writeUTF("Hello");
            // 写入Object:
            output.writeObject(Double.valueOf(123.456));
        }
        System.out.println(Arrays.toString(buffer.toByteArray()));

        var inputStream = new ByteArrayInputStream(buffer.toByteArray());
        try (ObjectInputStream input = new ObjectInputStream(inputStream)) {
            int n = input.readInt();
            String s = input.readUTF();
            Double d = (Double) input.readObject();
            System.out.println(n);
            System.out.println(s);
            System.out.println(d);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
