
# appsync-graphql-nodejs-serverless
Nodejs based Serverless Appsync implementation of GraphQL

This is an ongoing exploration of implementing GraphQL with Serverless Appsync


--
To work offline we need local dynamodb - you can get jar from https://s3-us-west-2.amazonaws.com/dynamodb-local/dynamodb_local_latest.tar.gz

In order to get away with future changes and existing issue with serverless-dynamodb-local: ^0.2.38, committed .dynamodb folder to github


-- 
To quick start

```
cd lambda-functions/layers/vendor/nodejs/
npm i  //install all dependencies for lambda layers
cd ../../..
npm i //install all dependencies for project
```

Running the program
```
npm run offline
````

Testing - create book
```
POST  - http://localhost:62222/graphql

headers:
x-api-key:SOME_KEY

body - graphql
mutation createBook {
    createBook(input: {
        title: "Fifth Created Book"
    }) {
        id
        title
    }
}

```

List books
```
POST  - http://localhost:62222/graphql

headers:
x-api-key:SOME_KEY

body - graphql
query listBooks {
    listBooks(limit: 10) {
        items{
            id
            title
        }
        nextToken
    }
    
}
````

Deploy

```
sls deploy --stage dev
```

Test

```
https://m3rty6bp6ffdpg6bx3scnriawz.appsync-api.us-east-1.amazonaws.com/graphql

mutation createBook {
    createBook(input: {
        title: "First Created Book"
    }) {
        id
        title
    }
}


query listBooks {
    listBooks(limit: 10) {
        items{
            id
            title
        }
        nextToken
    }
    
}
```


ToDo:

-- Establish subscriptions
-- Postman websockets - https://blog.postman.com/postman-supports-websocket-apis/
-- Create lambda based graphql (https://github.com/michalkvasnicak/aws-lambda-graphql/tree/master/packages/chat-example-server,
https://github.com/michalkvasnicak/aws-lambda-graphql)
