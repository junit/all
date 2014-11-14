using ClientDemon.logic.${pkg}.message;
using ClientDemon.message;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClientDemon.logic.${pkg}.handler
{
    public class ${name}Handler : Handler
    {
        public override void exec(Message iMsg)
        {
        	${name}Message msg = (${name}Message)iMsg;
        	// TODO
        }
    }
}
