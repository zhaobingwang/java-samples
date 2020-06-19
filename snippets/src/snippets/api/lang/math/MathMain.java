package snippets.api.lang.math;

public class MathMain {
    public static void main(String[] args) {

        System.out.println("圆周率：" + Math.PI);
        System.out.println("自然对数基数：" + Math.E);

        System.out.println("-1的绝对值" + Math.abs(-1));
        System.out.println("1和2中的最大值是：" + Math.max(1, 2));

        // 向上取整。返回大于或等于参数的最小（最接近负无穷大） double值，等于一个数学整数。
        System.out.println("1.2向上取整：" + Math.ceil(1.2));
        // 向下取整。返回小于或等于参数的最大（最接近正无穷大） double值，等于一个数学整数。
        System.out.println("1.2向下取整：" + Math.floor(1.2));

        // 返回[0,1)之间的一个随机数
        System.out.println("[0,1)间的随机数：" + Math.random());

        // 三角函数
        double degrees = 45.0;
        double radian = Math.toRadians(degrees);    // 角度转弧度
        System.out.println(radian);
        System.out.format("%.1f 度的正弦值为 %.4f\n", degrees, Math.sin(radian)); // sin参数为以弧度表示的角度

        // 四舍五入
        // round() 方法返回一个最接近的 int、long 型值，四舍五入。
        // round 表示"四舍五入"，算法为Math.floor(x+0.5) ，即将原来的数字加上 0.5 后再向下取整，
        // 所以 Math.round(11.5) 的结果为 12，Math.round(-11.5) 的结果为 -11。
        System.out.println("5.1四舍五入：" + Math.round(5.1));
    }
}
