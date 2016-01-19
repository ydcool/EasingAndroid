### Easing-Android

[ ![Download](https://api.bintray.com/packages/ydcool/maven/easing-android/images/download.svg) ]
(https://bintray.com/ydcool/maven/easing-android/_latestVersion)

Android easing interpolators.Based on http://easing.net

#### Usage

1.Add dependence.

```java
    buildscript {
        repositories{
            jcenter()
        }
    }
```

```java 
    dependencies {
        compile 'me.ydcool:easing-android:latest.integration'
    }
```

2.Use easing interpolators same as android build-in interpolators.

```java 
    AlphaAnimation animation = new AlphaAnimation(0.f,1.f);
    animation.setDuration(300);
    animation.setInterpolator(new EaseOutCubicInterpolator());
    mView.startAnimation(animation);
```

#### TODO

* finish demo app

#### License
 
    Copyright 2016 Ydcool
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
  
    http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
    
