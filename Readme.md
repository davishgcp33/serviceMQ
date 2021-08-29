
This Project is a basic Example of how we can leverage RabbitMQ and Redis for asynchronously processing of messages and using the power of Redis locks which is an alternate of reentrant locks for processing messages by a single thread per user


Flow of the Program:-

Redis Configuration and Rabbit MQ Configuration bean gets created when application gets started up and creates the connection.
Once the connection is up and running the rabbit listener gets activated and it creates a connection with the defined queue and starts listening.
When message is received cache is checked for the message is put in the cache and the lock is acquired and the message is processed.
If message is already their try to acquire the lock and if not then push the message back to the queue.
Read the next message.
