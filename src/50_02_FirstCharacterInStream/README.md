[TOC]

## 字符流中第一个不重复的字符

请实现一个函数用来找出字符流中第一个只出现一次的字符。
例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
当从该字符流中读出前六个字符"google"时，第一个只出现一次的字符是"l"。
如果当前字符流没有存在出现一次的字符，返回#字符。

### 解法
+ 思路与50_01类似：每次读入一个新字符，就在哈希表对应位置加1，查找时只需遍历一次哈希表即可；
+ 同理，此处利用数组实现简易的哈希表


#### 代码
```java
public class FirstCharacterInStream
{
    public StringBuilder sb = new StringBuilder();
    public int[] map = new int[256];

    /**
     * 从字符流中读取新字符
     *
     * @param ch 新字符
     */
    public void insert(char ch)
    {
        sb.append(ch);
        map[(int) ch]++;
    }

    /**
     * 第一个只出现一次的字符
     *
     * @return 字符
     */
    public char firstAppearingOnce()
    {
        for (char ch : sb.toString().toCharArray())
        {
            if (map[(int) ch] == 1)
            {
                return ch;
            }
        }
        return '#';
    }
}
```



### 测试用例参考
1. 功能测试（字符串中仅存在只出现一次的字符；字符串中不存在只出现一次的字符；字符串中所有字符都只出现一次）。
2. 特殊输入测试（字符串为null）。
