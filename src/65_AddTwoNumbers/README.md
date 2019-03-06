[TOC]

## 不用加减乘除做加法

写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号

### 解法
+ 模拟十位数相加的过程，都采用位运算来操作：
  1. 先不考虑进位，让各位上的数相加；
  2. 然后计算进位；
  3. 把两个数相加并重复以上步骤


#### 代码
```java
public class AddTwoNumbers
{
    /**
     * 两数加法
     *
     * @param num1 数1
     * @param num2 数2
     * @return 相加结果
     */
    public int add(int num1, int num2)
    {
        int sum = 0, carry = 0;
        while (num2 != 0)
        {
            // 各位相加，不考虑进位
            sum = num1 ^ num2;
            
            // 计算进位
            carry = (num1 & num2) << 1;
            
            // 重复上述步骤
            num1 = sum;
            num2 = carry;
        }
        return num1;
    }
}
```



### 测试用例参考
1. 输入正数、负数和0



### 相关问题
1. 不使用新的变量，交换两个变量的值。
+ 基于加减法：
```java
a = a + b;
b = a - b;
a = a - b;
```

+ 基于异或：
```java
a = a ^ b;
b = a ^ b;
a = a ^ b;
```






