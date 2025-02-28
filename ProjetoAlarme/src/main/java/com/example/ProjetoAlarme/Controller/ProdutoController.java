package com.example.ProjetoAlarme.Controller;

import com.example.ProjetoAlarme.Model.Produto;
import com.example.ProjetoAlarme.Repository.InterFaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private InterFaceRepository produtoRepository;

    @GetMapping("/")
    public String listarProdutos(Model model) {
        model.addAttribute("produtos", produtoRepository.findAll());
        return "index";
    }

    @GetMapping("/adicionar")
    public String adicionarProdutoForm(Model model) {
        model.addAttribute("produto", new Produto());
        return "adicionarProduto";
    }

    @PostMapping("/adicionar")
    public String adicionarProduto(@ModelAttribute Produto produto) {
        if (produto != null && produto.getNome() != null && produto.getPreco() > 0) {
            produtoRepository.save(produto);
        }
        return "redirect:/produtos/";
    }

    @GetMapping("/editar/{id}")
    public String editarProdutoForm(@PathVariable("id") int id, Model model) {
        Produto produto = produtoRepository.findById(id).orElse(null);
        if (produto != null) {
            model.addAttribute("produto", produto);
            return "editarProduto";
        }
        return "redirect:/produtos/";
    }

    @PostMapping("/editar")
    public String editarProduto(@ModelAttribute Produto produto) {
        produtoRepository.save(produto);
        return "redirect:/produtos/";
    }

    @GetMapping("/deletar/{id}")
    public String deletarProduto(@PathVariable("id") int id) {
        produtoRepository.deleteById(id); 
        return "redirect:/produtos/";
    }
}
