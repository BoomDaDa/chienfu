var recipient = 'user@server.com',
     subject   = 'Hi',
     message  = 'Write the body of your message here';

location.href = 'http://mail.google.com/mail/?view=cm&fs=1'+
                '&to=' + recipient +
                '&su=' + subject +
                '&body=' + message +
                '&ui=1';
var sendGmail = function(opts){
    var str = 'http://mail.google.com/mail/?view=cm&fs=1'+
              '&to=' + opts.to +
              '&su=' + opts.subject +
              '&body=' + opts.message +
              '&ui=1';
    location.href = str;
}
sendGmail({
    to: 'user@server.com',
    subject: 'hi',
    message: 'Write the body of your message here'
});
sendGmail({
    to: 'user@server.com',
    subject: 'hi',
    message: 'This is a large message with \n'+
             'more than two lines \n'+
             'and goes on and on and on'
});