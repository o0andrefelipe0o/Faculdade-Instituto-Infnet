using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Mvc.RazorPages;
using System.Collections.Generic;
using System.IO;

namespace Teste_de_Performance___TP2.Pages.CityManager
{
    public class ReadNotesModel : PageModel
    {
        private readonly IWebHostEnvironment _environment;

        public ReadNotesModel(IWebHostEnvironment environment)
        {
            _environment = environment;
        }

        public List<string> Files { get; set; } = new();

        public string? SelectedFileName { get; set; }

        public string? FileContent { get; set; }

        public void OnGet()
        {
            LoadFiles();
        }

        public void OnGetView(string fileName)
        {
            LoadFiles();

            string safeFileName = Path.GetFileName(fileName);

            string filePath = Path.Combine(
                _environment.WebRootPath,
                "files",
                safeFileName
            );

            if (safeFileName != fileName ||
                !safeFileName.EndsWith(".txt") ||
                !System.IO.File.Exists(filePath))
            {
                return;
            }

            SelectedFileName = safeFileName;

            FileContent = System.IO.File.ReadAllText(filePath);
        }

        private void LoadFiles()
        {
            string directory = Path.Combine(
                _environment.WebRootPath,
                "files"
            );

            if (Directory.Exists(directory))
            {
                foreach (string file in Directory.GetFiles(directory, "*.txt"))
                {
                    Files.Add(Path.GetFileName(file));
                }
            }
        }
    }
}
