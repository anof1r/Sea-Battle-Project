import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;

import java.util.Collection;
import java.util.List;

public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        //Lists.newArrayList from Google Guava
        List<String> collection = Lists.newArrayList("OneString", "TwoString", "TreeString");

        //CollectionUtils.isNotEmpty from Apache Collections
        if (CollectionUtils.isNotEmpty(collection)) {
            System.out.println("Collection is not empty!");
        } else {
            System.out.println("Collection is empty");
        }
    }

}
