package Prova.Produto;

import java.util.List;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Produto getProdutoById(@PathVariable Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new ConfigDataResourceNotFoundException("Produto com ID " + id + " não encontrado."));
    }

    @PostMapping
    public ResponseEntity<Produto> createProduto(@Validated @RequestBody Produto produto) {
        Produto novoProduto = produtoRepository.save(produto);
        return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @Validated @RequestBody Produto produto) {
        Produto produtoAtualizado = produtoRepository.findById(id)
                .orElseThrow(() -> new ConfigDataResourceNotFoundException("Produto com ID " + id + " não encontrado."));
        produtoAtualizado.setNome(produto.getNome());
        produtoAtualizado.setPreco(produto.getPreco());
        return new ResponseEntity<>(produtoRepository.save(produtoAtualizado), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        produtoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
