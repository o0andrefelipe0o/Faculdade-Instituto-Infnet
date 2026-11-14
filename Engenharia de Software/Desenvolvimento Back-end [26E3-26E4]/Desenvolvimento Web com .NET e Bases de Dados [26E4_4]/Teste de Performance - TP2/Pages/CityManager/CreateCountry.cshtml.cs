using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using Teste_de_Performance___TP2.Models;

namespace Teste_de_Performance___TP2.Pages.CityManager
{
    public class CreateCountryModel : PageModel
    {
        [BindProperty]
        public List<InputModel> Countries { get; set; } = new()
        {
            new(),
            new(),
            new(),
            new(),
            new()
        };

        public List<Country> CreatedCountries { get; set; } = new();

        public void OnPost()
        {
            if (!ModelState.IsValid)
            {
                return;
            }

            foreach (var input in Countries)
            {
                CreatedCountries.Add(new Country
                {
                    CountryName = input.CountryName,
                    CountryCode = input.CountryCode
                });
            }
        }

        public class InputModel
        {
            [Required(ErrorMessage = "Este campo é obrigatório.")]
            public string CountryName { get; set; } = string.Empty;

            [Required(ErrorMessage = "Este campo é obrigatório.")]
            [StringLength(2, MinimumLength = 2, ErrorMessage = "Este campo deve ter exatamente 2 caracteres.")]
            public string CountryCode { get; set; } = string.Empty;
        }
    }
}