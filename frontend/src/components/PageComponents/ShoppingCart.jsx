import React from "react";

const ShoppingCart = ({ cartItems }) => {
  return (
    <div className="bg-gray-100 p-4 rounded-md my-6">
      <h2 className="text-2xl font-semibold mb-4">Shopping Cart</h2>
      {cartItems.length === 0 ? (
        <p className="text-gray-500">Your cart is empty</p>
      ) : (
        <div>
          {cartItems.map((item) => (
            <div key={item.id} className="border-b py-2">
              <p className="text-lg font-semibold">{item.name}</p>
              <p className="text-gray-500">Quantity: {item.quantity}</p>
              <p className="text-gray-500">Price: ${item.price}</p>
            </div>
          ))}
          <p className="mt-4 text-lg font-semibold">
            Total: ${calculateTotal(cartItems)}
          </p>
        </div>
      )}
    </div>
  );
};

// Helper function to calculate the total price
const calculateTotal = (cartItems) => {
  return cartItems.reduce((total, item) => total + item.price * item.quantity, 0);
};

export default ShoppingCart;
