package snippets.base;

import com.sun.deploy.util.StringUtils;
import snippets.base.common.StringUtil;
import snippets.base.services.StudentServices;

public class Main {

    public static void main(String[] args) {
//        RegExp.checkYear();
//        StudentServices.run();
        String str = null;
        System.out.println(StringUtil.isNullOrEmpty(str));
        System.out.println(StringUtil.isNullOrWhiteSpace(str));
    }
}
