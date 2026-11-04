using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;

namespace ProductCatalog.Pages
{
    public class AddEventModel : PageModel
    {
        [BindProperty]
        public Event NovoEvento { get; set; }

        public void OnGet()
        {
        }

        public void OnPost()
        {
            Action<Event> registrar = evento =>
            {
                Console.WriteLine("Novo evento criado!");
                Console.WriteLine($"Título: {evento.Titulo}");
                Console.WriteLine($"Data: {evento.Data}");
                Console.WriteLine($"Local: {evento.Local}");
            };

            registrar(NovoEvento);
        }
    }
}