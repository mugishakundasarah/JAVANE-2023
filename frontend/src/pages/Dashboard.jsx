import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { BASE_URL } from '../utils/BaseUrl';
import Product from '../components/PageComponents/Product';
import ProductList from '../components/PageComponents/ProductList';
import authHeader from '../utils/BearerAuth';

const Dashboard = () => {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    // Fetch products from the API
    fetchProducts();
  }, []);

  const fetchProducts = async () => {
    try {
      const response = await axios.get(`${BASE_URL}/products`, {headers: authHeader()});
      setProducts(response.data.data);
    } catch (error) {
      console.error('Error fetching products:', error);
    }
  };

  console.log(products)

  return (
    <div className="container mx-auto mt-8">
      <h1 className="text-2xl font-semibold mb-4">Product Dashboard</h1>
      <ProductList products={products}/>
    </div>
  );
};

export default Dashboard;
