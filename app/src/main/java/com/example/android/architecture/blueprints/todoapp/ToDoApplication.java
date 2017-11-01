package com.example.android.architecture.blueprints.todoapp;

import com.example.android.architecture.blueprints.todoapp.di.component.AppComponent;
import com.example.android.architecture.blueprints.todoapp.di.component.DaggerAppComponent;
import com.example.android.architecture.blueprints.todoapp.di.module.AppModule;
import com.example.android.architecture.blueprints.todoapp.di.module.TasksRepositoryModule;

import android.app.Application;

/**
 * Created by johnny on 2017/6/8.
 */

public class ToDoApplication extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        //这是实例化AppComponent，存放在Application中供程序中其他地方获取
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))//没有默认构造器的module，需要自己实例化
                .tasksRepositoryModule(new TasksRepositoryModule())//有默认构造器的可以不注入实例
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
