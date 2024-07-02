package Prova.Produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/produto"})
public class ProdutoController{
    @Autowired
    ProdutoRepository produtoRepository;

    public ProdutoController() {
    }

    @PostMapping({"/criar"})
    public Produto criarProduto(@RequestBody Produto produto) {
        return (Produto)this.produtoRepository.save(produto);
    }

    @GetMapping({"/lista"})
    public List<Produto> listarProdutos() {
        return this.produtoRepository.findAll();
    }

    @PutMapping({"atualizar/{id}"})
    public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        produto.setId(id);
        return (Produto)this.produtoRepository.save(produto);
    }

    @DeleteMapping({"deletar/{id}"})
    public void deletarProduto(@PathVariable Long id) {
        this.produtoRepository.deleteById(id);
    }
}
