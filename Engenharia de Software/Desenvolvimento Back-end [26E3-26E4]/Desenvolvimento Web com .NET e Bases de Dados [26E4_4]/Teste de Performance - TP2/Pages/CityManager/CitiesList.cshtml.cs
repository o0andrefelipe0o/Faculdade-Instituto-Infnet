using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using System.Collections.Generic;
using System.Linq;
using System;
using Teste_de_Performance___TP2.Models;

namespace Teste_de_Performance___TP2.Pages.CityManager
{
    public class CitiesListModel : PageModel
    {
        public List<string> Cities { get; set; } = new();

        public void OnGet()
        {
            Cities = CityStore.Cities;
        }

        public IActionResult OnPostDelete(string cityName)
        {
            var city = CityStore.Cities.FirstOrDefault(
                c => string.Equals(
                    c,
                    cityName,
                    StringComparison.OrdinalIgnoreCase
                )
            );

            if (city != null)
            {
                CityStore.Cities.Remove(city);
            }

            return RedirectToPage();
        }
    }
}
