[Dropwizard](http://www.dropwizard.io/)
==========

**Dropwizard is a Java framework for developing ops-friendly, high-performance, RESTful web services.**

Dropwizard pulls together stable, mature libraries from the Java ecosystem into a simple, light-weight package that lets you focus on *getting things* done.

Dropwizard has out-of-the-box support for sophisticated **configuration**, **application metrics**, **logging**, **operational tools**, and much more, allowing you and your team to ship a production-quality web service in the shortest time possible.

# Examples

> 1.HelloWorld

```sh

java -jar target/dropwizard-in-action-0.0.1-SNAPSHOT.jar db migrate dropwizard-in-action.yml

java -jar target/dropwizard-in-action-0.0.1-SNAPSHOT.jar server dropwizard-in-action.yml
```


```html
    GET     /filtered/hello (cn.lhfei.dropwizard.helloworld.resources.FilteredResource)
    GET     /hello-world (cn.lhfei.dropwizard.helloworld.resources.HelloWorldResource)
    POST    /hello-world (cn.lhfei.dropwizard.helloworld.resources.HelloWorldResource)
    GET     /hello-world/date (cn.lhfei.dropwizard.helloworld.resources.HelloWorldResource)
    GET     /people (cn.lhfei.dropwizard.helloworld.resources.PeopleResource)
    POST    /people (cn.lhfei.dropwizard.helloworld.resources.PeopleResource)
    GET     /people/{personId} (cn.lhfei.dropwizard.helloworld.resources.PersonResource)
    GET     /people/{personId}/view_freemarker (cn.lhfei.dropwizard.helloworld.resources.PersonResource)
    GET     /people/{personId}/view_mustache (cn.lhfei.dropwizard.helloworld.resources.PersonResource)
    GET     /protected (cn.lhfei.dropwizard.helloworld.resources.ProtectedResource)
    GET     /protected/admin (cn.lhfei.dropwizard.helloworld.resources.ProtectedResource)
    GET     /views/iso88591.ftl (cn.lhfei.dropwizard.helloworld.resources.ViewResource)
    GET     /views/iso88591.mustache (cn.lhfei.dropwizard.helloworld.resources.ViewResource)
    GET     /views/utf8.ftl (cn.lhfei.dropwizard.helloworld.resources.ViewResource)
    GET     /views/utf8.mustache (cn.lhfei.dropwizard.helloworld.resources.ViewResource)



    POST    /tasks/echo (cn.lhfei.dropwizard.helloworld.tasks.EchoTask)
    POST    /tasks/log-level (io.dropwizard.servlets.tasks.LogConfigurationTask)
    POST    /tasks/gc (io.dropwizard.servlets.tasks.GarbageCollectionTask)
```