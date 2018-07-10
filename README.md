# Calculator
Software Engineering course design I

软件介绍：
   Calculator是软件工程第46组(组长：郭秋洋，组员：仁青尼玛）的课程设计I，实现了《第46组计算器需求文档》需求的功能，并添加了更多必要的功能。

当前版本：
   5.0

更新历史： <pre> 
  5.0：添加junit4的测试框架，发现并解决了一批bug。 
  4.4：回调4.3的改动，优化代码布局。
  4.3：添加了科学记数法的E按钮取代原先的deg按钮并微调了按钮布局，优化了科学记数法的计算。
  4.2：调整了ui中部分按钮文字的大小以解决win7下显示不全的问题。
  4.1：对结果的科学记数法表示进行了优化，现在可以直接将科学记数法表示的表达式进行计算。
  4.0：增加Help链接自述文档，解决了点击按钮后，需点击输入框后键盘才能输入的问题。
  3.2：添加icon，优化了结果的显示，限制了无限小数位数。
  3.1：对三角函数的精度进行优化，解决了类似sinπ等于一个非常小的数情况，取消MC，MR，MS等按钮。
  3.0：计算器内部数据统一以String和BigDecimal存储，对UI进行美化，添加背景图片，按钮特效等。
  2.0：添加部分科学计算器的功能，添加错误处理机制，解决了单目运算符出错的bug，安装包集成jre环境。
  1.0：基本完成需求文档中标准计算器的功能，并完成UI的初步制作，完成了ui部件与后台事物的绑定。
</pre>
运行环境：<pre>
  软件自带jre1.8，exe版可直接在任何64位Windows系统上直接运行，可执行jar版应该能在任何安装有jre1.8及以上版本的系统上运行。
</pre>
功能介绍：

基本操作：<pre>
  通过键盘或鼠标点击按钮输入正确的表达式后，回车或点击按钮=即可得到结果。
</pre>
按键功能：

基本键： <pre>
  1.数字键0~9；
  2.四则运算＋－×÷；
  3.小数点·；
  4.分数线/；
  5.括号()；
  6.求模运算Mod;
  7.百分号%；
  8.阶乘！；
  9.求平方X²；
  10.求次方^；
  11.求平方根√；
  12.求x的y次方根x√y；
  13.自然对数：ln；
  14.求正弦sin；
  15.求余弦cos；
  16.求正切tan；
  17.逻辑与&；
  18.逻辑或|；
  19.逻辑异或：Xor；
  20.角度转弧度：deg。
</pre>
功能键：<pre>
  1.=：计算正确表达式的值，或返回错误信息；
  2.C；清除输入框的内容，但不清除ans；
  3.ESC：清除输入框的内容，同时清除ans；
  4.ans；存储上一次正确表达式的结果；
  5.←：清除一个字符；
  6.e：常数e；
  7.π：常数π。
</pre>
键盘对应功能键：<pre>
  1.=：回车；
  2.C：F5；
  3.ans：F1；
  4.←：backspace；
  5.其他：对应的键盘按键。
</pre>
链接：<pre>
  1：Help：帮助及自述文档。
</pre>
错误信息：<pre>
  1.Experssion Error!：错误格式的表达式；
  2.Illegal Expression!：无法计算或结果不存在的表达式；
  3.∞：最终结果或中间计算结果溢出；
  4.Divide by Zero Error!：除0错误。
</pre>
