using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using System;
using System.IO;

namespace Teste_de_Performance___TP2.Pages.CityManager
{
    public class SaveNoteModel : PageModel
    {
        private readonly IWebHostEnvironment _environment;

        public SaveNoteModel(IWebHostEnvironment environment)
        {
            _environment = environment;
        }

        [BindProperty]
        public InputModel Input { get; set; } = new();

        public string? SavedFileName { get; set; }

        public void OnPost()
        {
            string fileName = $"note-{DateTime.Now:yyyyMMddHHmmssfff}.txt";

            string directory = Path.Combine(_environment.WebRootPath, "files");

            Directory.CreateDirectory(directory);

            string filePath = Path.Combine(directory, fileName);

            System.IO.File.WriteAllText(filePath, Input.Content);

            SavedFileName = fileName;
        }

        public IActionResult OnGetDownload(string fileName)
        {
            string filePath = Path.Combine(
                _environment.WebRootPath,
                "files",
                Path.GetFileName(fileName)
            );

            if (!System.IO.File.Exists(filePath))
            {
                return NotFound();
            }

            return PhysicalFile(filePath, "text/plain", fileName);
        }

        public class InputModel
        {
            public string Content { get; set; } = string.Empty;
        }
    }
}
