using ClientDemon.logic.role.message;
using ClientDemon.message;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClientDemon.logic.role.handler
{
    public class ResRoleCreateHandler : Handler
    {
        public override void exec(Message iMsg)
        {
        	ResRoleCreateMessage msg = (ResRoleCreateMessage)iMsg;
        	// TODO
        }
    }
}
