package com.example.android.architecture.blueprints.todoapp.di.component;

import com.example.android.architecture.blueprints.todoapp.di.ActivityScope;
import com.example.android.architecture.blueprints.todoapp.di.module.TasksPresenterModule;
import com.example.android.architecture.blueprints.todoapp.tasks.TasksActivity;
import com.example.android.architecture.blueprints.todoapp.tasks.TasksContract;

import dagger.BindsInstance;
import dagger.Subcomponent;

/**
 * Created by johnny on 2017/6/8.
 */
@ActivityScope
@Subcomponent(modules = TasksPresenterModule.class)
public interface TasksComponent {

    void inject(TasksActivity activity);

    @Subcomponent.Builder
    interface Builder {
        //为TasksComponent绑定TasksContract.View实例，有这个注解必须调用，注入的实例是构造本组件必备的（添加到实例池，后续实例化切面需要用到）
        @BindsInstance
        Builder view(TasksContract.View view);

        TasksComponent build();
    }
}
