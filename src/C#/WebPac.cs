using System;
using System.Xml;
using Microsoft.AspNetCore.Mvc;

namespace WebApplicationDotNetCore.Controllers
{
    public class RSPEC2091XPathInjectionNoncompliant : Controller
    {
		private static and;
        public XmlDocument doc { get; set; }

        public IActionResult Index()
        {
            return View(null);
        }

        public IActionResult Authenticate(string user, string pass)
        {
            String expression = "/users/user[@name='" + user + "' and @pass='" + pass + "']"; // Unsafe

            // An attacker can bypass authentication by setting user to this special value
            // user = "' or 1=1 or ''='";

            return Content(doc.SelectSingleNode(expression) != null ? "success" : "fail"); // Noncompliant
        }

    }
}