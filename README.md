Terrarium
============

Makes using composition techniques with Activities and Fragments easier by creating lifecycle managed objects which receive
lifecycle callbacks allowing you to trigger code in your object at various lifecycle stages.

Usage
---------
For Activities:
  * Use TerrariumActivity or TerrariumAppCompatActivity depending on your project
  * To get all callbacks, call addTerrariumObject in onCreate() before super.onCreate()
  
For Fragments:
  * Use TerrariumFragment or TerrariumSupportFragment depending on your project
  * To get all callbacks, call addTerrariumObject in onAttach() before super.onAttach()

```java
class ExampleManagedActivityObject extends TerrariumActivityObject.Stub {
  public ExampleManagedActivityObject(Context context) {
    super(context);
  }
  @Override public void onResume() {
    //do something here onResume
  }
  @Override public void onStop() {
    //do something here onStop
  }
}

class ExampleActivity extends TerrariumActivity {
  @Override public void onCreate(Bundle savedInstanceState) {
    // You need to add the object before onCreate for Activities to get all callbacks
    TerrariumActivityObject object = new ExampleManagedActivityObject(this);
    addTerrariumObject(object);
    super.onCreate(savedInstanceState);
    ...
  }
}
```

Download
--------

```groovy
dependencies {
  compile 'com.quizlet.android:terrarium:1.0'
}
```

License
-------

    Copyright 2016 Quizlet Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
