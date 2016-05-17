# android_launchMode_demo
Android有四种启动模式，分别为standard、singleTop、singleInstance、singleTask。设置启动模式可以在AndroidManifest.xml中设置Activity的launchMode属性，Activity的默认启动模式为standard。所以，如果想设置Activity为standard模式可以不用给launchMode设置属性值。
#下面分别介绍下四种启动模式
##standard模式：
standard模式为Activity的默认启动模式，该模式下所有启动的Activity都在同一个task容器栈中，只要每次调用startActivity等相关方法都会创建一个Activity的实例，所以同一个task容器栈中可能存在着相同的Activity实例。
##singleTop模式：
设置Activity的启动模式为singleTop可以通过配置AndroidManifest.xml文件中的Activity的launchMode属性值来实现。
如字面意思，task 容器栈顶保持一个Activity的实例，如果某个Activity已经处于task容器栈顶，则下次创建Activity的实例时就会重用处于task容器栈顶的Activity实例。但是，如果Activity的实例并非在task容器栈的栈顶位置，则会重新创建新的Activity的实例，该模式在task容器栈中可能存在着相同的Activity实例。
##singleTask模式：
singleTask模式是比较狠的模式，如果设置了Activity的launchMode为singleTask，则会把Activity实例对象上面的所有实例全部清除掉，并且，task容器栈中永远只保留唯一一个实例对象。
如果已经有了Activity的实例在task 容器栈中，不论Activity的实例是在task容器栈的任何位置，都会被重用。所以，如果你的应用无论如何启动目标Activity，都要保证只有一个唯一的Activity实例，则可以使用该模式。
##singleInstance模式：
singleInstance模式，简单的说就是可以共享某个Activity。比如说，如果应用1的task容器栈中已经创建AActivity的实例，应用2如果想要调用AActivity则不需要重新创建AActivity的实例，直接可以共用AActivity的实例。


##测试步骤及结果
######使用到的命令(如不知如何使用请google)
* adb shell
* dumpsys activity activities

##standard模式跳转实例：
#####MainActivity – StandardModeActivity – SingleTopModeActivity – StandardModeActivity – SingleTaskModeActivity – StandardModeActivity

Activities=[ActivityRecord{dc3115c u0 com.zyl.demo.launchmode/.activity.MainActivity t37}, ActivityRecord{281ef31d u0 com.zyl.demo.launchmode/.activity.StandardModeActivity t37}, ActivityRecord{1ea68d5 u0 com.zyl.demo.launchmode/.activity.SingleTopModeActivity t37}, ActivityRecord{24f679b6 u0 com.zyl.demo.launchmode/.activity.StandardModeActivity t37}, ActivityRecord{c16c753 u0 com.zyl.demo.launchmode/.activity.SingleTaskModeActivity t37}, ActivityRecord{235a6dbc u0 com.zyl.demo.launchmode/.activity.StandardModeActivity t37}]


##singleTop模式跳转实例：
######MainActivity – StandardModeActivity – SingleTopModeActivity – StandardModeActivity – SingleTaskModeActivity – SingleTopModeActivity – SingleTopModeActivity

Activities=[ActivityRecord{19f60dab u0 com.zyl.demo.launchmode/.activity.MainActivity t38}, ActivityRecord{1566727f u0 com.zyl.demo.launchmode/.activity.StandardModeActivity t38}, ActivityRecord{15b23277 u0 com.zyl.demo.launchmode/.activity.SingleTopModeActivity t38}, ActivityRecord{11291550 u0 com.zyl.demo.launchmode/.activity.StandardModeActivity t38}, ActivityRecord{9c32b05 u0 com.zyl.demo.launchmode/.activity.SingleTaskModeActivity t38}, 
######以下部分被重用
######ActivityRecord{2bab27b2 u0 com.zyl.demo.launchmode/.activity.SingleTopModeActivity t38}]


##singleTask模式跳转实例：

######MainActivity—SingleTaskModeActivity—StandardModeActivity—StandardModeActivity—SingleTaskActivity

Activities=[ActivityRecord{149cb473 u0 com.zyl.demo.launchmode/.activity.MainActivity t35}, 
######以下部分被重用
######ActivityRecord{2bdeacf4 u0 com.zyl.demo.launchmode/.activity.SingleTaskModeActivity t35}, 

######以下部分被清除掉
######ActivityRecord{1ddba651 u0 com.zyl.demo.launchmode/.activity.StandardModeActivity t35}, ActivityRecord{3edad97 u0 com.zyl.demo.launchmode/.activity.StandardModeActivity t35}]
######ActivityRecord{2bdeacf4 u0 com.zyl.demo.launchmode/.activity.SingleTaskModeActivity t35}] 


######MainActivity – StandardModeActivity – StandardModeActivity – StandardModeActivity – SingleTaskModeActivity – StandardModeActivity – StandardModeActivity -- SingleTaskModeActivity

Activities=[ActivityRecord{2bf38438 u0 com.zyl.demo.launchmode/.activity.MainActivity t36}, ActivityRecord{ed8c94e u0 com.zyl.demo.launchmode/.activity.StandardModeActivity t36}, ActivityRecord{28c0b426 u0 com.zyl.demo.launchmode/.activity.StandardModeActivity t36}, ActivityRecord{24263403 u0 com.zyl.demo.launchmode/.activity.StandardModeActivity t36},
 
######以下部分被重用
######ActivityRecord{2048d3ac u0 com.zyl.demo.launchmode/.activity.SingleTaskModeActivity t36}, 

######以下部分被清除掉
######ActivityRecord{308226ca u0 com.zyl.demo.launchmode/.activity.StandardModeActivity t36}, ActivityRecord{10c522 u0 com.zyl.demo.launchmode/.activity.StandardModeActivity t36}]
######ActivityRecord{2048d3ac u0 com.zyl.demo.launchmode/.activity.SingleTaskModeActivity t36}]


##singleInstance模式跳转实例：

######MainActivity – StandardModeActivity – SingleInstanceActivity – StandarModeActivity – SingleTopModeActivity

##Task id:#39
Activities=[ActivityRecord{2361f6d3 u0 com.zyl.demo.launchmode/.activity.MainActivity t39}, ActivityRecord{1b8681e6 u0 com.zyl.demo.launchmode/.activity.StandardModeActivity t39}, 
######以下Activity实例没有
######SingleInstanceActivity
ActivityRecord{233b107 u0 com.zyl.demo.launchmode/.activity.StandardModeActivity t39}, ActivityRecord{1d3013cc u0 com.zyl.demo.launchmode/.activity.SingleTopModeActivity t39}]

##Task id:#40
Activities=[ActivityRecord{2229e7be u0 com.zyl.demo.launchmode/.activity.SingleInstanceModeActivity t40}]








