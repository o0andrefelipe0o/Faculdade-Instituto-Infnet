using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;

namespace Teste_de_Performance___TP1__Web_.Pages
{
    public class IndexModel : PageModel
    {
        public List<Produto> Produtos { get; set; } = new();

        public void OnGet()
        {
            Produtos = new List<Produto>
            {
                new Produto { Nome = "Notebook", Preco = 3500.00m },
                new Produto { Nome = "Mouse", Preco = 89.90m },
                new Produto { Nome = "Teclado", Preco = 159.90m }
            };
        }
    }

    public class Produto
    {
        public string Nome { get; set; } = "";
        public decimal Preco { get; set; }
    }
}
