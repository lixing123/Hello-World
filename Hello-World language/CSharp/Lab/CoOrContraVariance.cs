﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Lab
{
    [TestClass]
    public class CoOrContraVariance
    {


        [TestMethod]
        public void Learn()
        {
            // We should not wrtie the following code:
            // IList<String> names = new List<String>();
            // IList<object> objects = names;
        }
    }
}
