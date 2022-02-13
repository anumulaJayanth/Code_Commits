const controller = require('../Controllers/user');
const express = require('express');
const router = express.Router();

router.get('/getUsers',controller.getUser);
router.post('/createUser',controller.createUser);
router.put('/updateUser/:userId',controller.updateUser);
router.get('/getUsers/:userId',controller.getUserById)

module.exports = router;