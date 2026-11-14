using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using System.ComponentModel.DataAnnotations;

namespace Teste_de_Performance___TP2.Pages.CityManager
{
    public class CreateCityModel : PageModel
    {
        [BindProperty]
        public InputModel Input { get; set; } = new();

        public void OnPost()
        {
            if (!ModelState.IsValid)
            {
                return;
            }
        }

        public class InputModel
        {
            [Required(ErrorMessage = "Este campo é obrigatório.")]
            [MinLength(3, ErrorMessage = "Este campo deve ter no mínimo 3 caracteres.")]
            public string CityName { get; set; } = string.Empty;
        }
    }
}