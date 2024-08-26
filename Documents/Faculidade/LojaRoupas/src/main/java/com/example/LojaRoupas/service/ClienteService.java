@RestController
@RequestMapping("api/cliente")
public class ControllerCliente {
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Cliente cliente) {
        try {
            String mensagem = this.clienteService.save(cliente);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao tentar salvar: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Cliente>> findAll() {
        try {
            List<Cliente> lista = this.clienteService.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{idCliente}")
    public ResponseEntity<Cliente> findById(@PathVariable long idCliente) {
        try {
            Cliente cliente = this.clienteService.findById(idCliente);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{idCliente}")
    public ResponseEntity<String> delete(@PathVariable long idCliente) {
        try {
            String mensagem = this.clienteService.delete(idCliente);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao deletar", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{idCliente}")
    public ResponseEntity<String> update(@RequestBody Cliente cliente, @PathVariable long idCliente) {
        try {
            String mensagem = this.clienteService.update(cliente, idCliente);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao atualizar: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Endpoint para buscar cliente por CPF
    @GetMapping("/by-cpf")
    public ResponseEntity<Cliente> getByCpf(@RequestParam String cpf) {
        try {
            Cliente cliente = clienteRepository.findByCpf(cpf);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // Endpoint para buscar clientes pelo nome
    @GetMapping("/by-name")
    public ResponseEntity<List<Cliente>> getByNome(@RequestParam String nome) {
        try {
            List<Cliente> clientes = clienteRepository.findByNome(nome);
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // Endpoint para buscar clientes com idade maior ou igual a um determinado valor
    @GetMapping("/find-Great")
    public ResponseEntity<List<Cliente>> findByIdadeGreaterThanEqual(@RequestParam int idade) {
        try {
            List<Cliente> clientes = clienteRepository.findByIdadeGreaterThanEqual(idade);
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}