using ClientDemon.logic.account.message;
using ClientDemon.message;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClientDemon.logic.account.handler
{
    public class ResAccountLoginFailedHandler : Handler
    {
        public override void exec(Message iMsg)
        {
        	ResAccountLoginFailedMessage msg = (ResAccountLoginFailedMessage)iMsg;
        	// TODO
        }
    }
}
