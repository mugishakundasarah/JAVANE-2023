const Product = ({ name, price, addToCart, buyNow }) => {
  return (
    <div className="flex items-center justify-between p-4 border border-gray-300 rounded-md">
      <div>
        <h3 className="text-lg font-semibold">{name}</h3>
        <p className="text-gray-500">Price: ${price}</p>
      </div>
      <div className="bg-blue-500">
        <button
          onClick={addToCart}
          className="px-4 py-2 text-sm font-semibold text-white bg-blue-500 rounded hover:bg-blue-600 focus:bg-blue-600"
        >
          Add to Cart
        </button>
        <button
          onClick={buyNow}
          className="px-4 py-2 text-sm font-semibold text-white bg-green-500 rounded hover:bg-green-600 focus:bg-green-600"
        >
          Buy Now
        </button>
      </div>
    </div>
  );
};


export default Product;
