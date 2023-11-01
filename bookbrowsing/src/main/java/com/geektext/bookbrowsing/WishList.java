@RestController
@RequestMapping("/wishlist")
public class WishListController {

    @Autowired
    private WishListService wishListService;

    @PostMapping("/add/{bookId}")
    public ResponseEntity<?> addBookToWishList(@PathVariable Long bookId, @RequestHeader(value = "user-id") Long userId) {
        // Call the addBookToWishList method from the WishListService and return a response
    }

    @DeleteMapping("/remove/{bookId}")
    public ResponseEntity<?> removeBookFromWishList(@PathVariable Long bookId, @RequestHeader(value = "user-id") Long userId) {
        // Call the removeBookFromWishList method from the WishListService and return a response
    }

    @GetMapping("/get")
    public ResponseEntity<?> getWishList(@RequestHeader(value = "user-id") Long userId) {
        // Call the getWishList method from the WishListService and return a response
    }
