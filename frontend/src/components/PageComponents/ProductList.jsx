import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import Product from './Product';
import ShoppingCart from './ShoppingCart';
import Checkout from './Checkout';

const ProductList = ({ products }) => {
  const [cartItems, setCartItems] = useState([]);
  const [showCheckout, setShowCheckout] = useState(false);
  const navigate = useNavigate();

  const addToCart = (productId) => {
    const existingItem = cartItems.find((item) => item.id === productId);

    if (existingItem) {
      const updatedCartItems = cartItems.map((item) =>
        item.id === productId ? { ...item, quantity: item.quantity + 1 } : item
      );
      setCartItems(updatedCartItems);
    } else {
      const productToAdd = products.find((product) => product.id === productId);
      setCartItems([...cartItems, { ...productToAdd, quantity: 1 }]);
    }
  };

  const buyNow = (productId) => {
    setShowCheckout(true);
  };

  const handleCheckout = () => {
    setShowCheckout(true);
  };

  return (
    <div className="container mx-auto mt-8">
      {showCheckout ? (
        <Checkout cartItems={cartItems} />
      ) : (
        <>
          <ShoppingCart cartItems={cartItems} />
        
        <div className='flex items-center justify-between mb-4'>
          <h1 className="text-2xl font-semibold mb-4">Product List</h1>
          <button
            onClick={handleCheckout}
            className="px-4 py-2 mt-4 text-sm font-semibold text-white bg-green-500 rounded hover:bg-green-600 focus:bg-green-600"
            disabled={showCheckout}
          >
            Checkout
          </button>
        </div>
          {products.map((product) => (
            <Product
              key={product.id}
              name={product.name}
              price={product.price}
              addToCart={() => addToCart(product.id)}
              buyNow={() => buyNow(product.id)}
            />
          ))}
        </>
      )}
    </div>
  );
};

export default ProductList;
