# Consumer-Producer Spring Kafka example
### Run
Import as Maven project. Start Application.class.

### Usage examples　

#### Reject listener (Consumer throws exception)
```
curl 'http://127.0.0.1:8080/send/reject'
 ```

 #### Save listener (Consumer saves to file or database)
```
curl 'http://127.0.0.1:8080/send/save?type=FILE&content=Foo'
 ```
 OR
 ```
curl 'http://127.0.0.1:8080/send/save?type=DATABASE&content=Foo'
 ```

#### Logger listener (Consumer prints to console object content)
```
curl 'http://127.0.0.1:8080/send/log?content=Bar'
 ```

