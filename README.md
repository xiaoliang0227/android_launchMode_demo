# android_launchMode_demo
Android有四种启动模式，分别为standard、singleTop、singleInstance、singleTask。设置启动模式可以在AndroidManifest.xml中设置Activity的launchMode属性，Activity的默认启动模式为standard。所以，如果想设置Activity为standard模式可以不用给launchMode设置属性值。
###下面分别介绍下四种启动模式
######standard模式：
standard模式为Activity的默认启动模式，该模式下所有启动的Activity都在同一个task容器栈中，只要每次调用startActivity等相关方法都会创建一个Activity的实例，所以同一个task容器栈中可能存在着相同的Activity实例。
######singleTop模式：
设置Activity的启动模式为singleTop可以通过配置AndroidManifest.xml文件中的Activity的launchMode属性值来实现。
如字面意思，task 容器栈顶保持一个Activity的实例，如果某个Activity已经处于task容器栈顶，则下次创建Activity的实例时就会重用处于task容器栈顶的Activity实例。但是，如果Activity的实例并非在task容器栈的栈顶位置，则会重新创建新的Activity的实例，该模式在task容器栈中可能存在着相同的Activity实例。
######singleTask模式：
singleTask模式是比较狠的模式，如果设置了Activity的launchMode为singleTask，则会把Activity实例对象上面的所有实例全部清除掉，并且，task容器栈中永远只保留唯一一个实例对象。
如果已经有了Activity的实例在task 容器栈中，不论Activity的实例是在task容器栈的任何位置，都会被重用。所以，如果你的应用无论如何启动目标Activity，都要保证只有一个唯一的Activity实例，则可以使用该模式。
######singleInstance模式：
singleInstance模式，简单的说就是可以共享某个Activity。比如说，如果应用1的task容器栈中已经创建AActivity的实例，应用2如果想要调用AActivity则不需要重新创建AActivity的实例，直接可以共用AActivity的实例。

