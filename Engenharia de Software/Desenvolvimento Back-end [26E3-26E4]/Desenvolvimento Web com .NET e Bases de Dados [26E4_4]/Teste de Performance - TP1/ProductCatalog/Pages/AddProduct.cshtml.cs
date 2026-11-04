using Microsoft.AspNetCore.Mvc.RazorPages;

namespace ProductCatalog.Pages
{
    public class AddProductModel : PageModel
    {
        public string Nome { get; set; } = string.Empty;

        public string Preco { get; set; } = string.Empty;

        public bool ProdutoEnviado { get; set; }

        public void OnGet()
        {
        }

        public void OnPost()
        {
            Nome = Request.Form["Nome"];
            Preco = Request.Form["Preco"];

            ProdutoEnviado = true;
        }
    }
}