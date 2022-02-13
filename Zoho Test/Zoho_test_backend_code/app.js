const express = require('express');
const mongoose = require('mongoose');
const router = require('./Routers/index')
const bodyParser = require('body-parser')
var cors = require('cors')
const app = express();
app.use(cors())
app.use(bodyParser.json());
const connectionString = 'mongodb+srv://Jayanth:abcdefg@cluster0.hxncz.mongodb.net/mongo?retryWrites=true&w=majority'

const port = 3000;
app.use('/',router);

mongoose.connect(
    connectionString,{
        UseNewUrlParser: true,
        UseUnifiedTopology: true
    }
).then(() => {
    console.log('Connected to mongodb')
    app.listen(port, ()=>{
      console.log(`Server is up and running on port ${port}`)
    });
}).catch(err => {
    console.log(err)
})