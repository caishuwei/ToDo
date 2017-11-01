package com.example.android.architecture.blueprints.todoapp.di.component;

import com.example.android.architecture.blueprints.todoapp.data.source.TasksRepository;
import com.example.android.architecture.blueprints.todoapp.di.module.AppModule;
import com.example.android.architecture.blueprints.todoapp.di.module.TasksRepositoryModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by johnny on 2017/6/8.
 */
//单例注解
@Singleton
@Component(modules = {AppModule.class, TasksRepositoryModule.class})
public interface AppComponent {

    //可以直接在AppComponent获取TasksRepository，可以不通过注解注入直接拿。。。
    TasksRepository tasksRespository();

    //以下四个子组件都继承自本组件，所以也拥有本组件的实例池
    //直接可以在这里返回别的组件构建器？并没有发现有@Module和@Providers，难道是子组件的原因，还是因为所有的Builder都可以？
    //不知为何EditTaskComponent等组件不会产生DaggerEditTaskComponent
    AddEditTaskComponent.Builder addEditTaskComponentBuilder();

    StatisticsComponenet.Builder statisticsComponentBuilder();

    TaskDetailComponent.Builder taskDetailComponentBuilder();

    TasksComponent.Builder tasksComponentBuilder();

}
