const user = require('../Model/user_schema')
const bodyparser = require('body-parser');

exports.getUser=(req,res) => {
    user.find().then(
        result => {
            res.status(200).json({
                user: result,
                message: 'Success'
            });
        }
    ).catch(err => {
        res.status(500).json({
            error: err,
            message: 'not found'
        })
    })
}


exports.createUser=(req,res) => {
    const  {
        id,
        email,
        password,
        phonenumber
    }=req.body;
    const userobj = new user({
        "id":id,
        "email":email,
        "password":password,
        "phonenumber":phonenumber
    })
    userobj.save().then(
        result => {
            res.status(200).json({
                user:result,
                message: 'User Successfully Created'
            })
  
        }
    ).catch(err => {
        res.status(500).json({
            error: err,
            message: 'error creating user'
        })
    })
}

exports.updateUser=(req,res) => {
    const {
        id,
        email,
        password,
        phonenumber,
        textarea
    }=req.body;
    const userId=req.params.userId;
    user.findOneAndUpdate(
        {email:userId},
        {
            $set:{
                id : id,
                email : email,
                password: password,
                phonenumber: phonenumber,
                textarea: textarea
            }
        },
        {upsert: true}
    ).then(result => {
        res.status(200).json({
            user:result,
            message:'updated'
        })
    }).catch(err => {
        res.status(500).json({
            error: err,
            message: 'error updating user'
        })
    })
}

exports.getUserById = (req,res)=>{
    const userId=req.params.userId;
    user.find({email:{$in:[userId]}}
    ).then(result => {
        res.status(200).json({
            user:result,
            message:'User details fetched successfully'
        })
    }).catch(err => {
        res.status(500).json({
            error: err,
            message: 'error updating user'
        })
    })
}

// exports.getUserById= (req, res) => {
//     user.findById(req.params.id, (err, data) => {
//       if (err)
//         res.send(err);
//       res.json(data);
//     });
//   };