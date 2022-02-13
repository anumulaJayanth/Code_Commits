const mongoose = require('mongoose');
const schema = mongoose.Schema
const userSchema = new schema({
    "id":{
        type: 'string'
    },
    "email": {
        type: 'string'
    },
    "password": {
        type: 'string'
    },
    "phonenumber": {
        type: 'number'
    },
    "textarea":{
        type: 'string'
    }

})
module.exports = mongoose.model('user',userSchema,'Zoho')