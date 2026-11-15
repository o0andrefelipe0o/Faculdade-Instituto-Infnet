using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using System;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using Teste_de_Performance___TP2.Models;

namespace Teste_de_Performance___TP2.Pages.CityManager
{
    public class CreateCityModel : PageModel
    {
        [BindProperty]
        public InputModel Input { get; set; } = new();

        public void OnPost()
        {
            string cityName = Input.CityName?.Trim() ?? string.Empty;

            if (!string.IsNullOrWhiteSpace(cityName) &&
                CityStore.Cities.Any(city =>
                    string.Equals(
                        city,
                        cityName,
                        StringComparison.OrdinalIgnoreCase)))
            {
                ModelState.AddModelError(
                    "Input.CityName",
                    "Esta cidade já está cadastrada."
                );
            }

            if (!ModelState.IsValid)
            {
                return;
            }

            CityStore.Cities.Add(cityName);
        }

        public class InputModel
        {
            [Required(ErrorMessage = "Este campo é obrigatório.")]
            [MinLength(3, ErrorMessage = "Este campo deve ter no mínimo 3 caracteres.")]
            [RegularExpression(@"^\S(?:.*\S)?$", ErrorMessage = "Não são permitidos espaços no início ou no final.")]
            public string CityName { get; set; } = string.Empty;
        }
    }
}