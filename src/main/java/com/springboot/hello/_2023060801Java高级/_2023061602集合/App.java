package com.springboot.hello._2023060801Java高级._2023061602集合;

public class App {
    /**
     * 集合考察知识点
     *  1集合的整体框架
     *     集合的框架一共2大块
     *     一个是以Collection为核心接口的集合
     *     一个是以Map为核心的接口集合
     *
     *     Collection继承Iterable迭代器，collection集合以此   为基础遍历
     *
     *     Collection包含集合
     *     List:有序，可重复
     *          ArrayList:底层是数组，有序，遍历快，
     *              插入和删除速度慢，因为底层实现是数组，所以在数组扩容的时候，是进行System.arraycopy方法，创建数组后进行复制
     *              如果ArrayList的add方法，需要添加很多元素，最好指定ArrayList的最小容量，可以减少扩容次数，提升性能
     *          LinkedList:底层是一个双向链表，有序，遍历慢，
     *              插入和删除速度快，因为底层是个链表，插入和删除只要改变前后node节点的上下节点
     *          Vector:线程安全是List，其他性质和ArrayList相同，性能低
     *          Stack:继承自Vector
     *     Queue：队列不支持随Set机访问，先进先出原则，有序可重复
     *          LinkedList
     *          PriorityQueue优先队列，本身就是最小堆，堆顶元素最小
     *          ArrayDeque
     *     Set:无序，不可重复
     *        HashSet:底层就是HashMap,只不过元素是key，value是一个常量Object();因为HashMap的key是不允许重复，所以HashSet不重复
     *        LinkedHashSet
     *          继承自HashSet,底层也是LinkedHashMap存储元素，有一个链表，记录了存储顺序
     *        TreeSet实现了SortedSet接口，有序
     *     Map
     *      HashMap：原理，线程不安全,允许key和value为空，key只能有一个为空
     *      LinkedHashMap 继承自HashMap，另外维护了一个双向链表维护插入顺序
     *      Hashtable：原理和HashMap相同，线程安全的，历史遗留的类，不建议使用，方法上有synced关键字保证线程安全，
     *          建议使用CurrentHashMap使用线程安全的HashMap，不允许key和value为空
     *      TreeMap: 底层是红黑树实现的，key，value，left，right，parent，BLACK，有序
     *
     *      CurrentHashMap
     *          的实现原理，底层还是HashMap，
     *          jdk1.7currentHashMap,使用分段锁机制，有桶数组，每一个桶都有一把锁，这样就不是锁整个HashMap
     *          桶元素类继承是可重入锁，实现分段锁机制
     *          存储元素的
     *          桶元素+HashEntry+链表的形似
     *          jdk1.8放弃了锁分段机制，使用Node数组+链表+红黑树来存储，
     *          在数组容量大于64之后，当链表长度达到8，Node会转换为TreeNode
     *
     *          线程安全利用syned关键字和CAS操作保证，性能更高
     *     HashTable是锁整个数组
     */

}
