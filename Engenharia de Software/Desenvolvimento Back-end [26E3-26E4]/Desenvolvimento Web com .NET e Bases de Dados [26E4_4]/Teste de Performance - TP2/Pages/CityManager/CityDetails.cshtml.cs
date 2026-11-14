using Microsoft.AspNetCore.Mvc.RazorPages;

namespace Teste_de_Performance___TP2.Pages.CityManager
{
    public class CityDetailsModel : PageModel
    {
        public string CityName { get; set; } = string.Empty;

        public void OnGet(string cityName)
        {
            CityName = cityName;
        }
    }
}