
# LogcatViewer - Android Logcat Viewer

## Purpose
LogcatViewer is utility library which will allow user to view the logcat logs of the application on phone itself.   
It will be useful for tester to provide logs along with defects and also to developer to do initial analysis of defects.  
Moreever, if correct tags are used, it can also be useful for performance measurement, for monitoring network requests etc. etc.  

#### How to start LogcatViewer in your application?

1. Add following line to build.gradle.
```
repositories {
    maven {     
        url "https://jitpack.io"    
    }    
}  

dependencies { 
    implementation 'com.github.asgatech20:Android-Floating-Logger:Tag'
    }
```
2. Add following code to launch LogcatViewer floating view. - To launch logcatviewer floating view.
```java
LogcatViewer.showLogcatLoggerView(this);
```
3. Add following services to AndroidManifest.xml. - To register services.
```xml
<service android:name="com.fatangare.logcatviewer.service.LogcatViewerService"
            android:label="LogcatLoggerService"></service>
 <service android:name="com.fatangare.logcatviewer.service.LogcatViewerFloatingView"
            android:label="LogcatLoggerFloatingView" > </service>
 ```

*That's all!*  
  
It will launch floating window which will show logcat logs of the application.

## Authors

* [Ibrahim Ali](https://github.com/IbrahimAli2017)
* [Muhammad Noamany](https://github.com/muhammadnomany25)

## Based On Repo Of:

* https://android-arsenal.com/user/fatangare
 
