using Microsoft.AspNetCore.Mvc.RazorPages;
using System;
using System.Linq;
using Teste_de_Performance___TP2.Models;

namespace Teste_de_Performance___TP2.Pages.CityManager
{
    public class CityDetailsModel : PageModel
    {
        public string CityName { get; set; } = string.Empty;

        public bool CityNotFound { get; set; }

        public void OnGet(string cityName)
        {
            string searchedCity = cityName?.Trim() ?? string.Empty;

            var foundCity = CityStore.Cities.FirstOrDefault(
                city => string.Equals(
                    city?.Trim(),
                    searchedCity,
                    StringComparison.OrdinalIgnoreCase
                )
            );

            if (foundCity == null)
            {
                CityNotFound = true;
                return;
            }

            CityName = foundCity;
        }
    }
}