package xyz.chaobei.tinypool.web;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.chaobei.tinypool.TinyPoolExecutor;
import xyz.chaobei.tinypool.TinyPoolThreadExecutor;

import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/tiny-pool/pool")
public class TinyPoolController {

    private final TinyPoolExecutor tinyPoolExecutor;

    public TinyPoolController(TinyPoolExecutor tinyPoolExecutor) {
        this.tinyPoolExecutor = tinyPoolExecutor;
    }


    @GetMapping("/{key}")
    public ResponseEntity<Object> detail(@PathVariable("key") String key) {

        TinyPoolThreadExecutor executor = tinyPoolExecutor.getPool(key);
        TinyPoolThreadExecutor.TinyPoolInfo info = executor.info();

        return ResponseEntity.ok(info);
    }


    @GetMapping("/")
    public ResponseEntity<Object> list() {

        ConcurrentHashMap<String, TinyPoolThreadExecutor> pools = tinyPoolExecutor.getPools();
        Enumeration<String> keys = pools.keys();
        List<String> list = new LinkedList<>();

        while (keys.hasMoreElements()) {
            list.add(keys.nextElement());
        }

        return ResponseEntity.ok(list);
    }

}
